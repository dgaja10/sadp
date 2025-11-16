

#include<DHT.h> 
#define DHTTYPE DHT11 
int dhtSensorPin = 6;
DHT dht(dhtSensorPin, DHTTYPE); 
float t, h;
void setup()
{
Serial.begin(9600);
dht.begin();
pinMode(dhtSensorPin, INPUT);
delay(2000);
}