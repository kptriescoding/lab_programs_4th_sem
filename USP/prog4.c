#include <stdio.h>
#include <stdlib.h>
#include <setjmp.h>
    jmp_buf buf1,buf2;
void jumpfunc2(){
    printf("In jumpfunc2\n");
    longjmp(buf2,3);
}
void jumpfunc1(){
    printf("In jumpfunc1\n");
    int val=setjmp(buf2);
    if(val==3){
        printf("Return from jumpfunc2 to jumpfunc1\n");
        longjmp(buf1,1);
    }
    printf("Calling jumpfunc2\n");
    jumpfunc2();
}
int main(){
    int val;
    printf("In main\n");
    val=setjmp(buf1);
    if(val==1){
        printf("Return from jumpfunc1 to main\n");
        exit(0);
    }
    printf("Calling jumpfunc1\n");
    jumpfunc1();
}
