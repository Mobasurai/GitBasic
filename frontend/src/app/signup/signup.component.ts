import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  imports: [ReactiveFormsModule, RouterLink, CommonModule],
  template: `
    <div class="min-h-screen bg-gray-50 flex flex-col justify-center py-12 sm:px-6 lg:px-8">
      <div class="sm:mx-auto sm:w-full sm:max-w-md">
        <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
          Create your account
        </h2>
      </div>

      <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
        <div class="bg-white py-8 px-4 shadow sm:rounded-lg sm:px-10">
          <form [formGroup]="signUpForm" (ngSubmit)="onSubmit()" class="space-y-6">
            <div>
              <label for="username" class="block text-sm font-medium text-gray-700">
                Username
              </label>
              <div class="mt-1">
                <input id="username" type="text" formControlName="username" required
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
              <div *ngIf="signUpForm.get('username')?.errors?.['required'] && signUpForm.get('username')?.touched" 
                   class="text-red-500 text-sm mt-1">
                Username is required
              </div>
            </div>

            <div>
              <label for="email" class="block text-sm font-medium text-gray-700">
                Email address
              </label>
              <div class="mt-1">
                <input id="email" type="email" formControlName="email" required
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
              <div *ngIf="signUpForm.get('email')?.errors?.['required'] && signUpForm.get('email')?.touched" 
                   class="text-red-500 text-sm mt-1">
                Email is required
              </div>
              <div *ngIf="signUpForm.get('email')?.errors?.['email'] && signUpForm.get('email')?.touched" 
                   class="text-red-500 text-sm mt-1">
                Please enter a valid email
              </div>
            </div>

            <div>
              <label for="password" class="block text-sm font-medium text-gray-700">
                Password
              </label>
              <div class="mt-1">
                <input id="password" type="password" formControlName="password" required
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
              <div *ngIf="signUpForm.get('password')?.errors?.['required'] && signUpForm.get('password')?.touched" 
                   class="text-red-500 text-sm mt-1">
                Password is required
              </div>
            </div>

            <div>
              <button type="submit" [disabled]="signUpForm.invalid"
                class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 disabled:opacity-50">
                Sign up
              </button>
            </div>
          </form>

          <div class="mt-6">
            <div class="relative">
              <div class="relative flex justify-center text-sm">
                <span class="px-2 bg-white text-gray-500">
                  Already have an account? <a routerLink="/signin" class="font-medium text-indigo-600 hover:text-indigo-500">Sign in</a>
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  `
})
export class SignUpComponent {
  signUpForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.signUpForm = this.fb.group({
      username: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  onSubmit() {
    if (this.signUpForm.valid) {
      const { username, email, password } = this.signUpForm.value;
      this.authService.signUp(username, email, password).subscribe({
        next: () => {
          this.router.navigate(['/signin']);
        },
        error: (error) => {
          if (error.status === 409) {
            alert('Username or email already exists');
          } else {
            alert('An error occurred');
          }
        }
      });
    }
  }
}