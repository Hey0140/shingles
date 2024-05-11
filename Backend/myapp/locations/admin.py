from django.contrib import admin
from .models import Location

# Register your models here.
class LocationInLine(admin.StackedInline):
    model = Location
    can_delete=False
    verbose_name_plural="location"

admin.site.register(Location)