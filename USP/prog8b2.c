#include<stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
int main(){
int fd;
fd=open("/tmp/fifo",O_RDWR);
char buf[100];
printf("Message to be sent is\n");
scanf("%[^\n]s",buf);
printf("Process 2 writing in fifo file\n");
write(fd, buf,sizeof(buf));
}
