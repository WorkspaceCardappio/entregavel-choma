import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'formatPhoneNumber'
})
export class PhoneNumberPipe implements PipeTransform {

  transform(phoneNumber: string): string {

    if (!phoneNumber) {
      return '';
    }

    return `({${phoneNumber.slice(0, 1)}) ${phoneNumber.slice(2, 6)}-${phoneNumber.slice(7, 10)}`;
  }
}
