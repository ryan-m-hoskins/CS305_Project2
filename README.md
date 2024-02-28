# CS305_Project2
Repository for the Artemis Financial project in CS304

- Briefly summarize your client, Artemis Financial, and their software requirements. Who was the client? What issue did they want you to address? 

Artemis Financial is a consulting company that specializes in the financial planning among other services relevant in the finance industry. It's unclear whether they have international clients or are localized in a particular area. The main objective of Artemis Financial was to modernize their operations, which including incorporating security into their web application. The application was built using the Spring Framework and sought to fucntion as a web platform for creating, managing, and storing tailored financial plans for their clients. The primary concern, or issue, Artemis Financial expressed was the need to both modernize the platform and enhance its security - specifically secure communication, utilizing cryptography algorithms, and establishing a way to perform a checksum on data. 

- What did you do very well when you found your client’s software security vulnerabilities? Why is it important to code securely? What value does software security add to a company’s overall wellbeing?

An initial evaluation was performed to review Artemis Financials' unique needs, discover industry best practices, and review their code base. Part of the review revealed several concerning vulnerabilities that mostly stemmed from poor coding practices and severely outdated dependencies. One area that I feel I did well was the dependency check and addressing the lack of input validation their program had. The code base provided did not utilize any form of input validation, sanitation, or any other method of securing user input. Additionally, I feel the hashing algorithm and salting implemented into the project proved to be an effective way to bolster the application's security regarding communication. By first reviewing the context of the application and the client's needs, I was able to identify the top areas of concern and determine what should be prioritized. Secure code is critical for many reasons. One such reason in the context of this project is Artemis Financial meeting government regulations and requirements. As a company in the financial industry, there are specific requirements related to their security and handling of data that must be met to avoid financial penalties or legal repurcussions. Additionally, security ensures their clients sensitive data remains safe, untampered with, and private. This leads into why security offers plenty of value for a company. Not only can they avoid legal consequences, fees, and penalities, but they can also avoid the reputational damage that would incur from a security breach - leading to a lack of trust in their services. 

What part of the vulnerability assessment was challenging or helpful to you?

The most challenging part of the vulnerability assessment was honestly the diagram itself that we were supposed to reference. It's a very vague diagram that doesn't provide any sort of context or explanation for anything involved in it. Aside from the diagram itself, I found figuring out pretty much everything in the code base and interpretting the dependency report to be a really overwhelming process. Due to the lack of an introduction to this or instruction in the project, it was pretty overwhelming to figure out how to implement the dependency check, as well as learning to interpret the vulnerabilities from the check. Due to how outdated the project is, there were upwards of 120 vulnerabilities that were present in the report.

How did you increase layers of security? In the future, what would you use to assess vulnerabilities and decide which mitigation techniques to use?

To enhance the security, several methods were followed. To start, it was important that input validation be implemented into the application, as that was a significant security risk. Secondly, secure communication and encryption were implemented. The application was modified to ensure the server only accepted traffic coming from a specific port and employed hashing to validate any data sent maintained its integrity through a checksum. Additionally, I salted the hash, which further strengthened the hasing algorithm to ensure there was an element of randomization. Depdendency checks and manually reviewing code to ensure it is secure are methods I would use in the future. 

How did you make certain the code and software application were functional and secure? After refactoring the code, how did you check to see whether you introduced new vulnerabilities?

Dependency checks were frequently used to not only initially assess the security vulnerabilities, but to also ensure any additional code or code that was modified didn't introduce additional vulnerabilities. Additional code review was performed as well to ensure there were not any unseen or unintentional mistakes or vulnerabilities introduced. 

What resources, tools, or coding practices did you use that might be helpful in future assignments or tasks?

I'm not sure I would use any of the resources that were provided in ths assignment. A lot of what was provided seemed severely out of date or extremely vague. The vulnerability diagram honestly introduced more confusion than it helped clarify. If I had to provide an answer, I'd say I would probably utilize the NIST or CSV database again. In other words, I'd probably just reference the OWASP standards. 

Employers sometimes ask for examples of work that you have successfully completed to show your skills, knowledge, and experience. What might you show future employers from this assignment?

To be completely honest, I don't know think I would use this assignment as any sort of example to a potential employer. Regarding the code itself, it hasn't been updated in roughly six or seven years, at least, and I would hope that I have more relevant, current, and well-structured examples of work that I could use to demonstrate my understanding. If I had to show something, it would just be the initial review of Artemis Financial where I listed security vulnerabilities, described some of them, and gave recommendations. 


