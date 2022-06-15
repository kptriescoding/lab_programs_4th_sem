#!/bin/bash
if test -d $1
then
echo "The files in the system are"
ls -lR $1
else 
echo "Invalid Directory"
exit
fi
echo "Enter the permission of the file to be read"
read per
ls -lR $1|grep -e $per