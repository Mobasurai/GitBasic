// profile.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService, ProfileAddInfoDto } from '../auth.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-profile',
  imports: [ReactiveFormsModule, RouterLink, CommonModule],
  template: `
    <div class="min-h-screen bg-gray-50 flex flex-col justify-center py-12 sm:px-6 lg:px-8">
      <div class="sm:mx-auto sm:w-full sm:max-w-2xl">
        <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
          Update Your Profile
        </h2>
      </div>

      <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-2xl">
        <div class="bg-white py-8 px-4 shadow sm:rounded-lg sm:px-10">
          <form [formGroup]="profileForm" (ngSubmit)="onSubmit()" class="space-y-6">
            <!-- Name -->
            <div>
              <label for="name" class="block text-sm font-medium text-gray-700">
                Name
              </label>
              <div class="mt-1">
                <input id="name" type="text" formControlName="name" required
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
              <div *ngIf="profileForm.get('name')?.errors?.['required'] && profileForm.get('name')?.touched" 
                   class="text-red-500 text-sm mt-1">
                Name is required
              </div>
            </div>

            <!-- Bio -->
            <div>
              <label for="bio" class="block text-sm font-medium text-gray-700">
                Bio
              </label>
              <div class="mt-1">
                <textarea id="bio" formControlName="bio" rows="3"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"></textarea>
              </div>
            </div>

            <!-- Image URL -->
            <div>
              <label for="image" class="block text-sm font-medium text-gray-700">
                Profile Image URL
              </label>
              <div class="mt-1">
                <input id="image" type="url" formControlName="image"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
              <div *ngIf="profileForm.get('image')?.errors?.['pattern'] && profileForm.get('image')?.touched" 
                   class="text-red-500 text-sm mt-1">
                Please enter a valid URL
              </div>
            </div>

            <!-- Birthday -->
            <div>
              <label for="birthday" class="block text-sm font-medium text-gray-700">
                Birthday
              </label>
              <div class="mt-1">
                <input id="birthday" type="date" formControlName="birthday"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
            </div>

            <!-- Gender -->
            <div>
              <label for="gender" class="block text-sm font-medium text-gray-700">
                Gender
              </label>
              <div class="mt-1">
                <select id="gender" formControlName="gender"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
                  <option value="">Select Gender</option>
                  <option value="male">Male</option>
                  <option value="female">Female</option>
                  <option value="other">Other</option>
                  <option value="prefer_not_to_say">Prefer not to say</option>
                </select>
              </div>
            </div>

            <!-- Phone -->
            <div>
              <label for="phone" class="block text-sm font-medium text-gray-700">
                Phone
              </label>
              <div class="mt-1">
                <input id="phone" type="tel" formControlName="phone"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
              <div *ngIf="profileForm.get('phone')?.errors?.['pattern'] && profileForm.get('phone')?.touched" 
                   class="text-red-500 text-sm mt-1">
                Please enter a valid phone number
              </div>
            </div>

            <!-- Organization -->
            <div>
              <label for="organization" class="block text-sm font-medium text-gray-700">
                Organization
              </label>
              <div class="mt-1">
                <input id="organization" type="text" formControlName="organization"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
            </div>

            <!-- Location -->
            <div>
              <label for="location" class="block text-sm font-medium text-gray-700">
                Location
              </label>
              <div class="mt-1">
                <input id="location" type="text" formControlName="location"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
            </div>

            <!-- Website -->
            <div>
              <label for="website" class="block text-sm font-medium text-gray-700">
                Website
              </label>
              <div class="mt-1">
                <input id="website" type="url" formControlName="website"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
              <div *ngIf="profileForm.get('website')?.errors?.['pattern'] && profileForm.get('website')?.touched" 
                   class="text-red-500 text-sm mt-1">
                Please enter a valid URL
              </div>
            </div>

            <!-- Social Links -->
            <div>
              <label class="block text-sm font-medium text-gray-700">
                Social Links
              </label>
              <div class="mt-1 space-y-2">
                <input type="url" placeholder="Social Link 1" formControlName="social1"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
                <input type="url" placeholder="Social Link 2" formControlName="social2"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
                <input type="url" placeholder="Social Link 3" formControlName="social3"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
                <input type="url" placeholder="Social Link 4" formControlName="social4"
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
              </div>
            </div>

            <!-- Submit Button -->
            <div>
              <button type="submit" [disabled]="profileForm.invalid"
                class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 disabled:opacity-50">
                Update Profile
              </button>
            </div>
          </form>

          <!-- Navigation Link -->
          <div class="mt-6">
            <div class="relative">
              <div class="relative flex justify-center text-sm">
                <span class="px-2 bg-white text-gray-500">
                  <a routerLink="/dashboard" class="font-medium text-indigo-600 hover:text-indigo-500">
                    Back to Dashboard
                  </a>
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  `
})
export class ProfileComponent {
  profileForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService, // Use AuthService instead of ProfileService
    private router: Router
  ) {
    this.profileForm = this.fb.group({
      name: ['', Validators.required],
      bio: [''],
      image: ['', Validators.pattern(/https?:\/\/.+\.(jpg|jpeg|png|gif|bmp|svg)$/i)],
      birthday: [''],
      gender: [''],
      phone: ['', Validators.pattern(/^\+?[1-9]\d{1,14}$/)], // E.164 international format
      organization: [''],
      location: [''],
      website: ['', Validators.pattern(/https?:\/\/.+/i)],
      social1: ['', Validators.pattern(/https?:\/\/.+/i)],
      social2: ['', Validators.pattern(/https?:\/\/.+/i)],
      social3: ['', Validators.pattern(/https?:\/\/.+/i)],
      social4: ['', Validators.pattern(/https?:\/\/.+/i)],
    });
  }

  onSubmit() {
    if (this.profileForm.valid) {
      const profileData: ProfileAddInfoDto = this.profileForm.value;
      this.authService.updateProfile(profileData).subscribe({
        next: () => {
          alert('Profile updated successfully!');
          this.router.navigate(['/dashboard']);
        },
        error: (error) => {
          console.error('Error updating profile:', error);
          alert('An error occurred while updating your profile.');
        }
      });
    }
  }
}
