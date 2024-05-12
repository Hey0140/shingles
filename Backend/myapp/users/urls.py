from django.urls import path
from .views import RegisterView, LoginView, UserViewSet
from rest_framework import routers

router = routers.DefaultRouter()
router.register('users', UserViewSet)

urlpatterns = [
    path('register/', RegisterView.as_view()),
    path('login/', LoginView.as_view()),
    
]

urlpatterns = router.urls