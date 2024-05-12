from django.contrib.auth.models import User
from rest_framework import viewsets
from rest_framework import generics, status
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework.decorators import api_view
from rest_framework.generics import get_object_or_404

from .serializers import RegisterSerializer, LoginSerializer, FavoriteSerializer, UserSerializer
from .models import Favorite

class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer

class FavoriteAPI(APIView):
    def get(self, request):
        #즐겨찾기 모든 장소 제공. 앞단에서 있는지 확인 하며 등록
        favorites = Favorite.objects.all()
        serializer = FavoriteSerializer(favorites, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)


class RegisterView(generics.CreateAPIView):
    queryset = User.objects.all()
    serializer_class = RegisterSerializer

class LoginView(generics.GenericAPIView) :
    serializer_class = LoginSerializer

    def post(self, request):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        token = serializer.validated_data
        return Response({"token" : token.key}, status=status.HTTP_200_OK)