from django.db import models

class Location(models.Model):
    name=models.CharField(max_length=50, primary_key=True)
    review=models.TextField(blank=True)
    address=models.TextField(blank=True)
    opentime=models.TextField(blank=True)
    call=models.TextField(blank=True)
    image=models.ImageField(upload_to='location/', default='default.png')

    def __str__(self):
        return self.name
