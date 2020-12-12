from django.http import HttpResponseRedirect
from django.shortcuts import render
from .models import Student

from django.urls import reverse
from .forms import StudentForm



def index(request):
    allstu = Student.objects.all()

    context = {
        "stulist": allstu,

    }

    return render(request, 'index.html', context=context)

def stuadd(request):

    if request.method == "POST":
        form = StudentForm(request.POST)
        if form.is_valid():
            form.save()
            return HttpResponseRedirect(reverse('index'))
    else:
        form = StudentForm()

    context = {

        "form": form,
    }

    return render(request, 'stuadd.html', context=context)