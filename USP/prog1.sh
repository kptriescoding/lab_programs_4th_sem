#!/bin/bash
var1=$(file $1)
var2=($var1)
if [[ "${var2[1]}" == "block" || "${var2[1]}" == "character" || "${var2[1]}" == "directory" || "${var2[1]}" == "symbolic" ]]
then
echo "$1 is a ${var2[1]} ${var2[2]} file"
elif ["${var2[1]}" == "fifo"]
then
echo "$1 is a ${var2[1]} file"
elif [ "${var2[1]}" == "cannot" ]
then
echo "$1 is not a valid filename"
else
echo "$1 is a regular file"
fi
