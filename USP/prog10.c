#include <stdio.h> 
#include <string.h>
#include <unistd.h> 
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h> 
#include <sys/sem.h>
int main(){
	extern int errno;
	key_t key =ftok("testfile",17341);
	int shmid=shmget(key,4096,IPC_CREAT|0666);
	char *shmstr=(char*)shmat(shmid,NULL,0);
	int semid=semget(key,1,IPC_CREAT);
        int x = semctl( semid,0, GETVAL);
        int has_waited=0;
    if(x==-1){
        printf("Error due to insufficient permission or some other error\n");
        return 0;
    }
    printf("Waiting for shared memory to be available...\n");
    while(semctl( semid,0, GETVAL)!=0)has_waited=1;
     if(has_waited==1){
        printf("The data written by other Process in Shared memory is: %s\n",shmstr);
        return 0;
     }
    semctl(semid,0, SETVAL,1);
    printf("Shared memory is now available\nSemaphore with semid %d is now locked by Process %d\nEnter data to be entered in the shared memory\n",semid,getpid());
        scanf("%[^\n]s",shmstr);
        printf("Semaphore is now sleeping...\n");
        sleep(5);
        printf("The data in the shared memory is: %s\nSemaphore has been in unlocked\nProcess %d exiting...\n",shmstr,getpid());
    semctl(semid,0,SETVAL,0);
}
