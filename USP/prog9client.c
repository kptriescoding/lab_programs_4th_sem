#include<stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include<stdlib.h>
#include<string.h>
struct message
{
long mtype;
char mtext[100];
};
int main()
{
struct message *msgbuf=(struct message*)malloc(sizeof(struct message));
int msgid;
key_t key=1;
printf("Waiting For message queue\n");
msgid=msgget(key,0666);
while(msgid==-1){
msgid=msgget(key,0666);
}
printf("Client Process\n");
msgbuf->mtype=1;
printf("The Request to be sent is : Refresh Page\n");
strcpy(msgbuf->mtext,"Refresh Page");
msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
printf("Waiting for Response\n");
while(msgrcv(msgid,msgbuf,sizeof(msgbuf->mtext),2,IPC_NOWAIT)==-1);
printf("The response from the server is\n%s\n",msgbuf->mtext);
printf("Client Exited\n");
}
