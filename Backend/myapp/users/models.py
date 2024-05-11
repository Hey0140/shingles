from django.db import models
from locations.models import Location

# Create your models here.

class Favorite(models.Model):
    location = models.ForeignKey(Location, on_delete=models.CASCADE)

    def __str__(self):
        return str(self.location.subject)
    