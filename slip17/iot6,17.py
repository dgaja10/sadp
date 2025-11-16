#include <DHT.h>

#include<DHT.h> //define library for sensor
#define DHTTYPE DHT11 //define macro
int dhtSensorPin = 6;
DHT dht(dhtSensorPin, DHTTYPE); //pin initialization
float t, h;
void setup()
{
Serial.begin(9600);
dht.begin();
pinMode(dhtSensorPin, INPUT);
delay(2000);
}