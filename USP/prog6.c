#include<stdio.h>
#include<signal.h>
void handler_func(int signum){
switch(signum){
case SIGINT:
printf("\nInterrupt by Keyboard has taken place\nSignal No is %d\n",SIGINT);
break;
case SIGFPE:
printf("Floating Point Exception Has Occured\nSignal No is %d\n",SIGFPE);
break;
case SIGSEGV:
printf("Invalid memory refernce signal has taken place\nSignal No is %d\n",SIGSEGV);
break;
case SIGCHLD:
printf("Child process has terminated\nSignal No is %d\n",SIGCHLD);
break;
case SIGILL:
printf("Illegal Instruction\nSignal No is %d\n",SIGILL);
break;
default:
printf("Some other signal\n");
}
return;
}

int main(){
signal(SIGINT,handler_func);
signal(SIGFPE,handler_func);
signal(SIGSEGV,handler_func);
signal(SIGCHLD,handler_func);
signal(SIGILL,handler_func);
while(1);
}
