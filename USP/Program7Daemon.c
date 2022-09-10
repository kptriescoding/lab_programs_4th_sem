#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <syslog.h>
#include <string.h>
#include <fcntl.h>
#include <shadow.h>
#include <crypt.h>
#include <pwd.h>

static void skeleton_daemon()
{
    pid_t pid;
    pid = fork();

    if (pid < 0)
        exit(EXIT_FAILURE);
    if (pid > 0)
        exit(EXIT_SUCCESS);
    if (setsid() < 0)
        exit(EXIT_FAILURE);

    signal(SIGCHLD, SIG_IGN);
    signal(SIGHUP, SIG_IGN);

    pid = fork();
  
    if (pid < 0)
        exit(EXIT_FAILURE);
    if (pid > 0)
        exit(EXIT_SUCCESS);
    umask(0);
    chdir("/");

    int x;
    for (x = sysconf(_SC_OPEN_MAX); x > 0; x--)
    {
        close(x);
    }
    openlog("firstdaemon", LOG_PID, LOG_DAEMON);
}

int CheckPassword(const char *user, const char *password)
{
    struct passwd *passwdEntry = getpwnam(user);
    if (!passwdEntry)
    {
        printf("User '%s' doesn't exist\n", user);
        return 1;
    }

    struct spwd *shadowEntry = getspnam(user);
    if (!shadowEntry)
    {
        printf("Failed to read shadow entry for user '%s'\n", user);
        return 1;
    }

    return strcmp(shadowEntry->sp_pwdp, crypt(password, shadowEntry->sp_pwdp));
}
int main()
{
    skeleton_daemon();

    while (1)
    {
 
        syslog(LOG_NOTICE, "First daemon started.");
//       Write your fifo file path
        char *path = "/home/dileep/Documents/unix/fifo1";
        mkfifo(path, 0666);
//       Write your fifo file path
        char *path_msg = "/home/dileep/Documents/unix/fifo_msg";
        mkfifo(path_msg, 0666);
        int fd = open(path, O_RDONLY);
        char name_pass[100];
        read(fd, name_pass, sizeof(name_pass));
        close(fd);

        char delim[] = " ";
        char *ptr = strtok(name_pass, delim);
        char *name = malloc(sizeof(char) * 200);
        char *pass = malloc(sizeof(char) * 100);
        name = ptr;
        ptr = strtok(NULL, delim);
        pass = ptr;

        int fd1 = open(path_msg, O_WRONLY);

        int compare = CheckPassword(name, pass);
        if (compare == 0)
        {
            write(fd1, "correct", sizeof("correct"));
            break;
        }
        else
        {
            write(fd1, "incorrect", sizeof("incorrect"));
            break;
        }
        sleep(2000);
        break;
        close(fd1);
    }

    syslog(LOG_NOTICE, "First daemon terminated.");
    closelog();

    return EXIT_SUCCESS;
}
