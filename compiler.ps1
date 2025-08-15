javac -d  bin ./src/Main.java ./src/Views/*.java ./src/Controllers/*.java ./src/Utils/*.java ./src/Objects/*.java;
jar cfm TicTacToe.jar MANIFEST.MF -C bin/ .