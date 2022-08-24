#include <sys/select.h>
#include <sys/time.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
int main(){
int fd[2];
pipe(fd);
int rv = fork();
if(rv==0)
{
char buf[100];
printf("This is Child \nEnter the data to be to sent to Parent\n");
scanf("%[^\n]s",buf);
printf("Data sent successfully\n");
write(fd[1],buf,sizeof(buf));
}
else
{
char buf[100];
fd_set fds;
struct timeval tv;
FD_ZERO(&fds);
FD_SET(fd[0],&fds);
tv.tv_sec = 10;
tv.tv_usec = 0;
int  r= select(fd[0]+1,&fds,NULL,NULL,&tv);
if(r == -1)
printf("Error in Select");
else if(r)
{
printf("This is Parent\nThe data sent by child is\n");
read(fd[0],buf,1000);
printf("%s\n",buf);
}else
printf("No Data written by the Child in 10 seconds ,Exiting...\n");
}
}