REM �v���O�����̃R�[�h������Ԃɂ���

@echo off


REM MySQL�̃f�B���N�g��

set MYSQLPATH=C:\Program Files\MySQL\MySQL Server 8.0\bin\


REM �ڑ�����

set DB_NAME=orcl

set PASS=comecomeshoppass
set USER_ID=root
set OPTION=--default-character-set=utf8


REM �X�N���v�g���s

"%MYSQLPATH%mysql.exe" %OPTION%  %DB_NAME% -u %USER_ID% -p%PASS%< drop.sql
"%MYSQLPATH%mysql.exe" %OPTION%  %DB_NAME% -u %USER_ID% -p%PASS%< create.sql@echo off