#!/bin/bash
echo "The files in the system are"
if test -d $1
then
echo "$(ls -lR $1)"
else 
echo "Invalid Directory"
echo "Enter the permission of the file to be read"
read per
echo "$( ls -lR $1|grep -e $per )"