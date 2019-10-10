$find . -name "*.java" > sources.txt
$javac -sourcepath . @sources.txt

Java weather.Simulator scenario.txt
