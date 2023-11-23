#!/bin/bash

##################################
#       jNode main script        #
#      for Termux / Android	 #
# Copyright (c) 2023 by 2:50/700 #
##################################

# Choose your TimeZone here
TZ=Europe/Moscow

ROOT="`dirname $(readlink -f $0)`/../"
JPID=$(pidof java)
JAR="$ROOT/lib"

# colors
gray='\033[1;30m'
red='\033[1;31m'
green='\033[1;32m'
yellow='\033[1;33m'
violet='\033[1;34m'
magenta='\033[1;35m'
blue='\033[1;36m'
white='\033[1;37m'
reset='\033[0m'

cd $ROOT
if [ "$1" == "" ]; then
	echo -en ${red}"No arguments expected!\n${green}Usage: ${reset}$0 ${green}(${magenta}start${green}|${blue}stop${green}|${yellow}restart${green}|help)\n${green}See help for details.\n"${reset}
fi

case "$1" in

	start)
	if [ $JPID > "0" ]; then
		echo -en ${yellow}"\njNode already running...\n\n${reset}PID: ${red}$JPID\n\n"${reset}
		exit
	fi
	for I in $JAR/*.jar; do A="$A:$I"; done
	nohup java -Xmx300m -server -cp "$A" -Dusertimezone="$TZ" jnode.main.Main ./etc/jnode.conf & echo -en ${yellow}"\njNode sucessfully started!${reset}\n\n";
	echo -en "PID: ${red}$JPID\n\n"${reset}
	;;

	stop)
	if [ $JPID > "0" ]; then
		kill $JPID
		echo -en ${yellow}"\njNode stopped!\n\n"${reset}
	else
		echo -en "\njNode ${yellow}NOT${reset} started!\n\n"
	fi
	;;

	restart)
	$0 stop;
	$0 start
	echo -en ${yellow}"jNode sucessfully REstarted!\n"${reset}
	;;

	help)
	echo -en ${yellow}"\nThis version of jNode FTN Platform is designed to work ${red}only${yellow} under Termux/Android!\n\n${green}Usage: ${white}$0 ${green}(${magenta}start${green}|${blue}stop${green}|${yellow}restart${green}|${red}build${green}|help)\n${red}Warning!${reset} Argument '${red}build${reset}' will reset all passwords!\n${green}Sample: ${white}/.run.sh start ${green}will started jNode...\n\n${yellow}If nothing works out, finally read the instructions!\n${green}RTFM you can found here: ${blue}https://github.com/Lagunix/jnode\n\n"${reset}
	;;
	*)

if [ "$1" <> "0" ]; then
	echo -en ${red}"Illegal arguments expected!\n${green}Usage: ${reset}$0 ${green}(${magenta}start${green}|${blue}stop${green}|${yellow}restart${green}|help)\nSee help for details.\n"${reset}
fi
	exit 0;
esac
