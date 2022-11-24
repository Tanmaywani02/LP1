import picamera
from time import sleep 

camera = picamera.PiCamera()

camera.capture('pi_image.jpg') 
sleep(5)
print("Done!!")