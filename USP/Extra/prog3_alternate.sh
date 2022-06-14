#/bin/bash
files=$(find $1 -type f)  
echo "The files in the system are"
for file in $files
do
file=${file}
echo $file
done
echo "Enter the permission of the file to be read"
read per
for file in $files
do
file_per=$(stat -c "%a" $file)
if [ "$file_per" == "$per" ]
then
echo ${file}
fi
done