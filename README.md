# DreamCo
![DreamCo Banner](https://github.com/jerrykingbob/DreamCo/blob/master/Dreamco%20Banner.png?raw=true)


## Introduction
DreamCo is a Java desktop program developed in fulfilment of the course requirements for WIA1002 Data Structure. This was the first, full GUI project I developed with the GraphStream Java library for network-graph visualisation on top of the native Java libraries. While this program fulfils most of the functional requirements stipulated in the project task sheet, there are a number of major bugs that have yet to be rectified, so the project in its current state is unstable.

## Project Overview
I've included a pdf ("WIA1002 Data Structure Project") which explains the project in greater detail. Nonetheless, I've included the following snippits from the document to give you a general idea on what this project is about:


DreamCorporation has contacted University of Malaya to hire talented students like you to build 
the system. Depending on the capability of your system, the equivalent reward will be added to 
your Data Structure assignment marks.

DreamCorporation want to test you out to see if you’re fit for the job, here’s the skills you need:
1. Traversing in Tree using Reference - Make sure you understand parent-child relationship
2. Encryption and Decryption - To protect information leaking to interested parties
3. Primary school maths - Percentage, Addition and Multiplication... Seriously??Project Requirements

Figure 2: Implementation of Multi-level 
marketing scheme as a tree
Definition with examples (Referring to Figure 2)
❖ Direct Downline : C’s direct downlines are E and F
❖ All Downlines : C’s all downlines are E, F, G, H, I, J
❖ Direct Upline : C’s direct upline is B
❖ All Uplines : C’s all uplines are A, B

How does MLM work - by example?
1. User A is the root node owned by DreamCorporation, its commission will be added to the 
company revenue.
2. User J just paid RM 50 and signed up.
a. User F will get RM 25 (50%)
b. User C will get RM 6 (12%)
c. User B will get RM 4.5 (9%)
d. User A will get RM 3 (6%)
e. Since root node (User A) is reached, whatever’s that left RM 11.5 (3% + 20%) will 
be added to company revenue.

Encryption & Decryption
1. Every user will need to have an encrypted_name to protect their identity.
2. Only the company has the KEY to decrypt the encrypted_name to real_name.
a. encrypt(NAME, KEY) → ENCRYPTED_NAME
b. decrypt(ENCRYPTED_NAME, KEY) → NAME
3. When signing up the new user, you must only save the encrypted name.
4. Every time you want to see the user original NAME, you should type in the KEY.




## Dev Team (Contributors)- Team 2r2
<a href="https://github.com/jerrykingbob">![Github Jeremiah](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)</a> Jeremiah Dudun Henry (jerrykingbob)
<br><a href="https://github.com/Raihansatar">![Github Raihan](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)</a> Raihan (raihansatar)
<br><a href="https://github.com/Amirmasz">![Github Amir](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)</a> Amir Syafiq (Amirmasz)
<br><a href="https://github.com/najmieadnan">![Github Najmi](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)</a> Najmi Adnan (najmieadnan)
