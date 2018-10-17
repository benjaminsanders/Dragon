# Dragon
Dragons Lair

## About

Dragons Lair is a program I created in Java to simulate a Dungeons & Dragons Brewery & Inn.

It generates characters with in depth details, assigned correct naming patterns to the correct gender/races, as well as changing certain aspects of their characters based on other aspects. For example, if a character generator assigns "Nobility" as a background, the character is much less likely to have little money. Likewise, a character given the background of "Hermit" likely won't have much money.

In addition to the character generation, it also simulates their actions. Having more drinks means spending more money (as long as they have it), and customers buying drinks will lower the ale resources. There is a subsection that very simply simulates the ale making process as well, but this is not touched on in depth.

## Installation

Simple!

```
git https://github.com/benjaminsanders/Dragon.git
cd Dragon
sudo javac Dragon.java
java Dragon
```

### Dependancies

This program is designed to run on Raspberry Pi, but it can be compiled and run on any system with Java installed. Below is how to install java as required by this program for the Raspberry Pi.

```
sudo apt-get install oracle-java8-jdk
```

And it's done. Yep, that easy. Hopefully.
