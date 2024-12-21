** Версия для Termux/Android**

[![Последний релиз](https://img.shields.io/github/v/release/lagunix/jnode-android?include_prereleases&label=последний%20релиз&style=for-the-badge)](https://github.com/lagunix/jnode-android/releases/latest)
![Загрузки](https://img.shields.io/github/downloads/lagunix/jnode-android/total?style=for-the-badge)
![Размер репы](https://img.shields.io/github/repo-size/lagunix/jnode-android?style=for-the-badge)
![Code-size](https://shields.io/github/languages/code-size/lagunix/jnode-android?style=for-the-badge)
![Languages](https://shields.io/github/languages/count/lagunix/jnode-android?style=for-the-badge)
![Languages/top](https://shields.io/github/languages/top/lagunix/jnode-android?style=for-the-badge)
![Directory-file-count](https://shields.io/github/directory-file-count/lagunix/jnode-android?style=for-the-badge)
![LICENSE](https://img.shields.io/github/license/lagunix/jnode-android?color=blue&style=for-the-badge)
![Issues](https://shields.io/github/issues/Lagunix/jNode-Android?style=for-the-badge)
![Issues-pr](https://shields.io/github/issues-pr/Lagunix/jNode-Android?style=for-the-badge)
![Discussions](https://shields.io/github/discussions/Lagunix/jNode-Android?style=for-the-badge)
![Forks](https://shields.io/github/forks/Lagunix/jNode-Android?style=for-the-badge)
![Stars](https://shields.io/github/stars/lagunix/jnode-android?style=for-the-badge)
![Watchers](https://shields.io/github/watchers/lagunix/jnode-android?style=for-the-badge)
![Contributors](https://shields.io/github/contributors/lagunix/jnode-android?style=for-the-badge)
![Commit-activity](https://shields.io/github/commit-activity/w/lagunix/jnode-android?style=for-the-badge)
![Last-commit](https://shields.io/github/last-commit/Lagunix/jNode-Android?style=for-the-badge)
</div>

Особенности:
* используется синхронный интерфейс

Известные проблемы:
* [исправлено] успешная отправка через интерфейс loopback на  устройствах без root под Android-13+ ТОЛЬКО в случае, если вы получаете пакеты в одном сеансе (вы должны создать любой запрос к своему узлу из вашего Android FTN-клиента, например HotDoged, перед опросом узла)

Как установить:
* Установить Termux
* pkg update && pkg upgrade
* pkg install openjdk-17 (необязательно если уже установлен)
* pkg install maven
* pkg install git
* git clone https://github.com/Lagunix/jNode-Android.git
* cd jnode
* install mvn -Dmaven.test.skip=true
* cd .m2/repository/jnode/jnode-android-assembly/1.5
* unzip jnode-android-assembly-1.5-** dev** /jnode/
* cd jnode 
* отредактировать ./etc/jnode.conf
* cd ./bin
* отредактировать TZ (актуальная временная зона) ./bin/run.sh или ./bin/ru.sh (русскоязычный скрипт)
* chmod +x run.sh / ru.sh
* примечание: run.sh / ru.sh  используйте только с bash!
* run.sh / ru.sh
* Наслаждайтесь!

Кроме того, вы можете установить jNode в Termux/proot (или proot-distro) таким же образом, но обратите внимание на свободную память, настоятельно рекомендуется не менее 6 Гб оперативной памяти или больше.

С уважением к https://github.com/hssergey

**jNode** — это комплексное кроссплатформенное приложение, заменяющее собой комплект узлового софта (мейлер, тоссер и трекер) для ip-only узлов.

Приложение полностью написано на языке Java (1.7) и распространяется по лицензии Apache License 2.0.

В текущей версии уже реализованы следующие возможности:
- Получение и отправка бандлов по binkp/1.1-совместимому протоколу
- Хранение всех данных (линки, арии, подписки итд) в базе данных
- Создание бандлов в момент соединения
- Многопоточность
- Роутинг нетмейла и rewrite-процессор (по аналогии с FTrack)
- Поддержка файлэх
- Управление роботами
- Простейший робот AreaFix (подписка, отписка, рескан, `%LIST` и `%HELP`)
- Простейший робот FileFix (подписка, отписка, `%LIST` и `%HELP`)

Приложение построено с использованием библиотеки [ORMLite](http://ormlite.com), поэтому поддерживаются следующие СУБД: DB2, Derby, H2, hSQL, mySQL, Netezza, Oracle, PostgreSQL, SQLite, MS SQL Server.
