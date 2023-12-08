**Xiaohong Kou Lab 3 README**

***1. The "Create A Country" page***
<img width="1800" alt="截屏2023-09-17 19 41 52" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/88b1cc7e-0309-47f4-a5fe-48776d32d379">

***2. The user input passes validation***
<img width="1800" alt="截屏2023-09-17 20 40 45" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/3f665523-064b-47ad-914c-c7fb2d65a41e">

***3. The user input passes validation***
<img width="1800" alt="截屏2023-09-17 19 53 45" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/65b801dd-1313-4243-8239-aedd6f017d98">

***4. Implement database persistence***
<img width="601" alt="截屏2023-09-17 20 41 36" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/5370d14f-e8e7-419b-a576-5e586daf5240">


***5. Write a brief summary paragraph to document***
1. **Difference between the forward and redirect operations**:
   - **Forward**:
     - When a request is forwarded, the request is sent from one servlet to another internally within the server. The client browser is unaware of this transfer of control, and the browser's URL remains unchanged.
     - The original request and response objects are passed to the next resource, so they can share data using request attributes.
     - Forward is typically faster than redirect because it's an internal process within the server.
   - **Redirect**:
     - When a redirect is issued, the server sends a response back to the client browser, indicating that it needs to make a new request to a different URL. The browser then initiates a new request to the specified URL.
     - As it's a new request, the original request and response objects are not available. Any data that needs to be passed must be included in the URL or stored in a session or cookie.
     - The browser's URL will change to the redirected URL.

2. **Validating user submissions without the Bean Validation API standard**:
   - Before the Bean Validation API, validation was often done manually. This means:
     - Using conditional statements to check the data. For example, checking if a string is empty, if a number is within a certain range, or if an email format is valid.
     - Using regular expressions to validate the format of input data.
     - Returning feedback to the user if the validation fails, often by setting error messages in the request scope and forwarding back to the input form.

3. **Scaling to a real application with 100's of entities**:
   - Manually validating each entity without a standardized approach like the Bean Validation API can become cumbersome and error-prone.
   - Maintenance would be challenging. If validation rules change, developers would need to find and update each instance where the rule is applied.
   - Consistency across entities might be hard to maintain, leading to potential discrepancies in how similar validations are handled for different entities.
   - Overall, while it's possible, it would be less efficient and more prone to errors compared to using a standardized validation approach.

4. **Why no additional dependencies were needed**:
   - The project might already be using a framework or platform (like Java EE or Jakarta EE) that includes these dependencies by default. For instance, if you're using Jakarta EE, it already includes the Bean Validation and JDBC APIs.
   - The server or platform on which the application is deployed might provide these implementations. For example, application servers like Payara or WildFly come with built-in support for many standard APIs.


