@echo off

echo Please select project:\n
echo [1]: mybatis-generator-plus
echo [2]: spring-plugins
echo [3]: annotations
echo [4]: common

set /p PROJECT_INDEX=":"

@echo select %PROJECT_INDEX%

if "%PROJECT_INDEX%" equ "1" (
	echo start build mybatis-generator-plus jar...
	call gradlew :mybatis-generator-plus:build :mybatis-generator-plus:jarToLocalMaven -x test --offline;
	exit;
) 

if "%PROJECT_INDEX%" equ "2" (
	echo start build spring-plugins jar...
	call gradlew :spring-plugins:build :spring-plugins:jarToLocalMaven -x test --offline
	exit;
)

if "%PROJECT_INDEX%" equ "3" (
	echo start build annotations.jar
	call gradlew :annotations:build :annotations:jarToLocalMaven -x test --offline
	exit;
) 

if "%PROJECT_INDEX%" equ "4" (
	echo start build common.jar
	call gradlew :common:build :common:jarToLocalMaven -x test --offline
	exit;
) 
