#!/bin/bash

##################################
#     Основной скрипт jNode      #
#       для Termux/Android	 #
#  Copyright (c) 2023  2:50/700  #
##################################

# Временная зона
TZ=Europe/Moscow
# Вычисление рабочего каталога jNode
ROOT="`dirname $(readlink -f $0)`/../"
BIN="`dirname $(readlink -f $0)`"

# Номер задачи jNode (PID)
JPID=$(pidof java)

# Папка библиотек
JAR="$ROOT/lib"

# Цвета
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

# Если скрипту не дана команда
if [ "$1" == "" ]; then
	echo -en "\n${red}Не указана команда!\n\n${green}Использование: ${reset}$0 ${green}(${magenta}start${green}|${blue}stop${green}|${yellow}restart${green}|help)\n${green}\n"${reset}
fi

# Если скрипту дана заданная команда (start|stop|restart|build|help)
case "$1" in

# Запуск jNode (команда start)
	start)
	if [ $JPID > "0" ]; then
		echo -en ${yellow}"jNode уже запущена...\n"${reset}
		exit
	fi
	for I in $JAR/*.jar; do A="$A:$I"; done
	nohup java -Xmx300m -server -cp "$A" -Duser.timezone="$TZ" jnode.main.Main ./etc/jnode.conf & echo -en ${yellow}"jNode успешно запущена!\n"${reset}
	;;

# Остановка jNode (команда stop)
	stop)
	if [ $JPID > "0" ]; then
		kill $JPID
		echo -en ${yellow}"\njNode остановлена!\n\n"${reset}
	else
		echo -en "\njNode ${yellow}НЕ${reset} запущена!\n\n"
	fi
	;;

# Перезапуск jNode (команда restart)
	restart)
	cd $BIN
	$0 stop;
	$0 start
	echo -en ${yellow}"jNode перезапущена!\n"${reset}
	;;

# Помощь (команда help)
	help)
	echo -en ${yellow}"\nЭта версия jNode создана для работы ${red}только${yellow} под Termux/Android!\n\n${green}Использование: ${white}$0 ${green}(${magenta}start${green}|${blue}stop${green}|${yellow}restart${green}|${red}build${green}|help)\n${red}Внимание!${reset} Команда '${red}build${reset}' сбросит все пароли!\n${green}Пример: ${white}/.ru.sh start ${green}запускает jNode...\n\n${yellow}Если ничего не работает, прочтите, наконец, инструкцию!\n${green}RTFM можно найти тут: ${blue}https://github.com/Lagunix/jNode-Android\n\n"${reset}
	;;
	*)

# Если скрипту дана не заданная команда
if [ "$1" <> "0" ]; then
        echo -en "\n${red}Указана неверная команда!\n\n${green}Использование: ${reset}$0 ${green}(${magenta}start${green}|${blue}stop${green}|${yellow}restart${green}|help)\n\n"${reset}
fi
	exit 0;
esac
