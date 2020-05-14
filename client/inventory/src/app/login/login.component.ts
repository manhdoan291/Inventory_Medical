import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AuthenticationService } from '../_services';

@Component({
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error = '';
    classError = '';
    storage: any;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService
    ) {
        // redirect to home if already logged in
        if (this.authenticationService.currentUserValue) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        debugger
        this.authenticationService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                    debugger
                    this.storage = sessionStorage;
                    this.submitted = true;
                    //if (data.role === 'admin') {
                    //    this.loading = false;
                    //    this.router.navigate(['admin']);


                    //}
                    //else
                    //    if (data.role === 'user') {
                    //        this.loading = false;
                    //        this.router.navigate(['/']);
                    //    }
                    //    else {
                    //        this.loading = false;
                    //        this.router.navigate([this.returnUrl]);
                    //    }
                    this.loading = false;
                    if (data.status === 501) {

                        this.error = "Tài khoản không tồn tại!";
                        this.classError = "error";
                    }
                    else
                        if (data.status === 502) {

                            this.error = "Mật khẩu không đúng hoặc tài khoản đã bị xóa!";
                            this.classError = "error";
                        } else {
                            debugger
                            this.router.navigate([this.returnUrl]);
                        }


                },
                error => {
                    this.error = error;
                    this.loading = true;
                });
        console.log(this.storage);

    }
    
}
