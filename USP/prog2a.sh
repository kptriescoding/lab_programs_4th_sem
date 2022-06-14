#!/bin/bash
echo "Enter the String"
read string
echo "Enter the start position of the substring"
read POS
echo "Enter the length of the substring"
read LEN
echo "The required substring is ${string:$POS:$LEN}"