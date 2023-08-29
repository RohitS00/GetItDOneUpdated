import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoggedInServiceProviderService } from '../logged-in-service-provider-service.service';

@Component({
  selector: 'app-post-service',
  templateUrl: './post-service.component.html',
  styleUrls: ['./post-service.component.css']
})
export class PostServiceComponent implements OnInit {
  service = {
    title: '',
    zipCode: '',
    price: '',
    description: ''
  };
  loggedInServiceProviderId: string | null = null;

  constructor(
    private http: HttpClient,
    private router: Router,
    private loggedInServiceProviderService: LoggedInServiceProviderService
  ) { }

  ngOnInit(): void {
    this.loggedInServiceProviderId = this.loggedInServiceProviderService.getLoggedInServiceProviderId();
  }

  postService() {
    console.log(this.loggedInServiceProviderId);
    if (!this.loggedInServiceProviderId) {
      console.error('Service provider ID not available.');
      return;
    }

    // Send a POST request to the backend API endpoint to add the service
    const apiUrl = `http://localhost:8080/addService/${this.loggedInServiceProviderId}`;
    this.http.post<any>(apiUrl, this.service)
      .subscribe({
        next: (response) => {
          console.log('Service posted successfully:', response);
          alert("Service posted successfully"); // Redirect to a confirmation page after posting the service
        },
        error: (error) => {
          console.error('Error posting service:', error);
          // Handle error: show error message, etc.
        }
      });
  }
  viewCustomerHistory() {
    // Redirect to the customer history component route when the button is clicked
    this.router.navigate(['/customer-history']);
  }
  logout() {
    this.router.navigate(['login/provider']); // Redirect to the homepage
  }
  alertFunction(){
    alert("you hav a job!");
  }
}
