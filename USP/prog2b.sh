#!/bin/bash
if test -f $1
then
echo
var1=$(wc --line $1)
var2=($var1)
echo "The number of lines is $var2"
else
echo "The file is not valid"
fi