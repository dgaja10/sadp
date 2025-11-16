#define LDR_PIN A0 // LDR connected to analog pin A0
#define LED_PIN D4 // LED connected to digital pin D4 (GPIO2)
void setup() {
Serial.begin(115200); // Start serial monitor
pinMode(LED_PIN, OUTPUT); // Set LED pin as output
}
void loop() {
int ldrValue = analogRead(LDR_PIN); // Read analog value from LDR
Serial.print("LDR Value: ");
Serial.println(ldrValue);
// Adjust threshold as needed. Lower value = brighter environment
int threshold = 500;
if (ldrValue < threshold) {
digitalWrite(LED_PIN, LOW); // Turn OFF LED (LOW = OFF for D4 on NodeMCU)
} else {
digitalWrite(LED_PIN, HIGH); // Turn ON LED
}
delay(500); // Delay for stability
}