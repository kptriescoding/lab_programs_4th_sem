#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
int main()
{
    printf("Enter the name and passoword one by one\n");
    char name[100];
    char pass[100];
    pass[0] = ' ';
    scanf("%s", name);
    scanf("%s", pass + 1);
    strcat(name, pass);

    char *path = "/home/dileep/Documents/unix/fifo1";
    int fd = open(path, O_WRONLY);
    int no = write(fd, name, sizeof(name));
    close(fd);
    char *path_msg = "/home/dileep/Documents/unix/fifo_msg";

    int fd1 = open(path_msg, O_RDONLY);
    char msg[100];
    read(fd1, msg, sizeof(msg));
    close(fd1);

    if (strcmp(msg, "correct") == 0)
    {
        printf("Password Correct\n");
        printf("The content of file is :\n");
        char path[100] = "/home/dileep/Documents/unix/sfile.c";

        int fdf = open(path,O_RDONLY);
        char content[200];
        read(fdf, content, sizeof(content));
        printf("%s\n",content);

    }
    else if (strcmp("incorrect", msg) == 0)
        printf("Password incorrect\n");

    return 0;
}
