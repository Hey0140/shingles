from django.conf.urls import include
from django.contrib import admin
from rest_framework import routers
from .views import LocationViewSet

router = routers.DefaultRouter()
router.register('locations', LocationViewSet)

urlpatterns = router.urls