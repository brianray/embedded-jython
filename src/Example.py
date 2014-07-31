__author__ = 'brray'

from com.brianray.embedded_jython import ExampleType

class Example(ExampleType):
    def say_hello(self):
        print "Hello"

if __name__ == "__main__":
    example = Example()
    example.say_hello()
