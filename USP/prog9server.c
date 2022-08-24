#include<stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include<stdlib.h>
struct message
{
long mtype;
char mtext[100];
};
int main()
{
struct message *msgbuf=(struct message*)malloc(sizeof(struct message));;
int msgid,len;
key_t key=1;
msgid=msgget(key,IPC_CREAT|0666);
printf("Server Process\n");
printf("Waiting for Client\n");
while(msgrcv(msgid,msgbuf,sizeof(msgbuf->mtext),1,IPC_NOWAIT)==-1);
printf("Client \nThe request is %s\n",msgbuf->mtext);
printf("The response to the request is\n");
scanf("%[^\n]s",msgbuf->mtext);
char garb;
scanf("%c",&garb);
msgbuf->mtype=2;
msgsnd(msgid,msgbuf,sizeof(msgbuf->mtext),IPC_NOWAIT);
printf("Response sent to Client\n");
}
