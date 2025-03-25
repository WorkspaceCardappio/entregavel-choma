import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'formatPhoneNumber'
})
export class PhoneNumberPipe implements PipeTransform {

  transform(phoneNumber: string): string {

    return phoneNumber ? `(${phoneNumber.slice(0, 2)}) ${phoneNumber.slice(2, 7)}-${phoneNumber.slice(7, 11)}` : '';
  }
}
