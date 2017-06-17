# CustomSoundSystem
An easy to use graphical user interface that allows users to bind custom audio effects to play on the push of a key!

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

## Prerequisites

What developer doesn't have this? </br>
[Java](https://java.com/en/) 

Our package dependancy manager. </br>
[Maven](https://maven.apache.org)

## Installing

### importing

```
git init

git clone https://github.com/BroManSalaam/CustomSoundSystem master
```

### compile and run with maven

```
mvn clean

mvn compile
```

now that it's compiled, serve it hot with your favorite IDE/compiler!
(I'll try to add the exec:java plugin command soon, but the resource paths are hard to configure!)

## Running the tests

I will have several test cases in our src/tests/java folder shortly!

to compile all of your test cases and run them...

```
mvn test-compile

mvn test
```

## Built With

A library that allows us to view the user's keystrokes [disclaimer](#disclaimer) </br>
[system-hook](https://github.com/kristian/system-hook)

A testing module for JavaFX
[TestFX](https://github.com/TestFX/TestFX)

The native java GUI library we used 
[JavaFX](http://docs.oracle.com/javase/8/javase-clienttechnologies.htm)

Our package dependancy manager
[Maven](https://maven.apache.org/)

## Authors

[BroManSalaam](https://github.com/BroManSalaam) - founder, lead developer

## License

This project is licensed under the APACHE 2.0 License - see the LICENSE.md file for details

#### Disclaimer<a name="disclaimer"></a>

This software uses a keyboard hook to listen for the user's keystrokes as part of the function of this program. 
This is by no means malicious, and will not attempt in any way shape or form, to record your keystrokes or distribute them.

## Acknowledgments

A hat tip to the following...

A fantastic fxml development tool which has aided us tremendously </br>
[Scene Builder](http://gluonhq.com/products/scene-builder/)

Our free dependable package manager </br>
[Maven](https://maven.apache.org)
