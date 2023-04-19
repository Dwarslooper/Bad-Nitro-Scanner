@echo off
color d
echo.
:::   _   _ _ _                _____                           _              __      _____  
:::  | \ | (_) |              / ____|                         | |             \ \    / /__ \ 
:::  |  \| |_| |_ _ __ ___   | |  __  ___ _ __   ___ _ __ __ _| |_ ___  _ __   \ \  / /   ) |
:::  | . ` | | __| '__/ _ \  | | |_ |/ _ \ '_ \ / _ \ '__/ _` | __/ _ \| '__|   \ \/ /   / / 
:::  | |\  | | |_| | | (_) | | |__| |  __/ | | |  __/ | | (_| | || (_) | |       \  /   / /_ 
:::  |_| \_|_|\__|_|  \___/   \_____|\___|_| |_|\___|_|  \__,_|\__\___/|_|        \(_) |____|    
for /f "delims=: tokens=*" %%A in ('findstr /b ::: "%~f0"') do @echo(%%A                                                                                           
echo.
echo     Discord Nitro scanner by Dwarslooper V 0.3
echo.
echo     This program's code is available on Github:
echo     https://github.com/Dwarslooper/Bad-Nitro-Scanner
echo     My Discord Server: dsc.gg/dwarsdc
echo.
echo     ======================================
echo     REMEMBER: This program consistently
echo     pings Discord's API to scan for valid
echo     codes. I am not responsible for any
echo     damage that might be caused by this.
echo     ======================================
echo.
echo.
set /p delay=Delay for Scanning Codes (in milliseconds): 
set /p maxScans=Max amount of Codes that should be scanned: 
set /p openOnSuccess=Open invite in browser on success (true, false): 
set /p checkAll=Directly check all links if they work (true, false): 
set /p outputPath=Output file path (optional): 
echo.
echo %delay% %maxScans% %openOnSuccess% %checkAll% %outputPath% "%~dp0"
echo.
echo     Press any key to start!
echo     To exit, press Ctrl + C or just close the program
pause>nul
echo.
color a
echo.
java -jar nitro.jar %delay% %maxScans% %openOnSuccess% %checkAll% "%~dp0"

color c
echo Exported log file! If the file is not present at the given location, check C:\Nitro for the file!

pause