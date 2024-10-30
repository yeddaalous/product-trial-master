import {Component, ViewEncapsulation} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {InputTextareaModule} from "primeng/inputtextarea";

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [
    FormsModule,
    ButtonModule,
    InputTextModule,
    InputTextareaModule,
  ],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {
  email: string = '';
  message: string = '';
  successMessage: string = '';

  sendMessage(): void {
    if (this.email && this.message && this.message.length <= 300) {
      this.successMessage = 'Demande de contact envoyée avec succès.';
      this.email = '';
      this.message = '';
    } else {
      this.successMessage = '';
    }
  }
}
