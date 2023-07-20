import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsumerRegisterComponent } from './consumer-register/consumer-register.component';
import { HomeComponent } from './home/home.component';
import { ConsumerLoginComponent } from './consumer-login/consumer-login.component';
import { ProviderRegisterComponent } from './provider-register/provider-register.component';
import { ProviderLoginComponent } from './provider-login/provider-login.component';
import { PostServiceComponent } from './post-service/post-service.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register/consumer', component: ConsumerRegisterComponent },
  { path: 'login/consumer', component: ConsumerLoginComponent },
  { path: 'register/provider', component: ProviderRegisterComponent },
  { path: 'login/provider', component: ProviderLoginComponent },
  {path: 'post-service/:SPid', component: PostServiceComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
