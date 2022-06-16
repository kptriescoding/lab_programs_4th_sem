#include<stdio.h>
#include<stdlib.h>
#include <sys/types.h>
#include<sys/wait.h>
#include <unistd.h>
int main(){
printf("Parent Process is Forking\n");
pid_t rv=fork();
if(rv==-1){
printf("Fork Failed\n");
}
else if(rv==0){
printf("The Child Process is executing\n");
   	char cmd[1000];
   	printf("Enter the command to be executed\n");
   	scanf("%[^\n]s",cmd);
   	printf("The output is \n");
   	system(cmd);
printf("The child proceess id is %d\n",getpid());
printf("The parent process id is %d\n",getppid());
exit(0);
}
else if(rv>0){
printf("The Parent Process is waiting\n");
wait(NULL);
printf("The Parent Process is executing\n");
printf("The child process id is %d\n",rv);
printf("The parent process id is %d\n",getpid());
}
}

