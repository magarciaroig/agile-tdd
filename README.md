agile-tdd
=========

Taste exercise to learn the tdd proposed flow.

The main objective of this exercise is to implement a file line counter of java input sources (or other C source code 'friendly' languages). The comments are no taked into account, that is :

* Blank lines are ignored
* Lines starting with '//' are being ignored
* Lines inside a '/\* .... \*/' block are being ignored as well

The proposed test flow process is as follows :

* Count all lines.
* Doesn't count a blank line.
* Doesn't count one line commnets '//'
* Doesn't count block comments '/\* ... \*/'
* Doesn't count code lines before comments in line

This execise is implemented in the context of the agile development course being performed at Akamon, starting from January 2014.

