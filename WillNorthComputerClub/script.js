document.addEventListener('DOMContentLoaded', function() {
    const terminalOutput = document.getElementById('terminal-output');
    const content = `
    Will North Computer Club
    Location : Williamsville North High school
    General Information:
    
    Official Name: The Computer Club
    Age Range: High School Students (typically 14-18 years old)
    Areas of Focus: Open to all areas of computer science based on member interests (programming, robotics, cybersecurity, etc.)
    Affiliation: Williamsville North High School
    Mission and Goals:
    
    Mission Statement: To foster a love of technology within the Williamsville North High School community by providing a platform for members to explore their interests, collaborate on projects, and push the boundaries of what's possible.
    Goals:
    Improve tech literacy across the school through workshops and presentations.
    Discuss and explore emerging technologies and trends.
    Investigate the ethical implications and creative potential of manipulating technology.
    Build a strong community of tech enthusiasts at Williamsville North High School.
    Activities and Events:
    
    Hackathons (coding marathons to solve problems)
    Workshops on various computer science topics
    Guest speaker sessions with industry professionals
    Presentations by members on their projects and interests
    Club meetings for discussions, brainstorming, and planning future events
    Open to member suggestions for additional activities
    Benefits of Membership:
    
    Learn new skills in programming, hardware, software, and more.
    Network with other students who share your passion for technology.
    Collaborate on projects and participate in hackathons.
    Gain exposure to new technologies and trends in the computer science field.
    Develop leadership and communication skills.
    Be part of a supportive community of tech enthusiasts.
    `;
    let index = 0;
    function typeLine() {
        if (index < content.length) {
            terminalOutput.textContent += content[index++];
            setTimeout(typeLine, 50); // Adjust typing speed here
        } else {
            // Typing effect is complete, now display the form
            document.getElementById('form-container').style.display = 'block';
        }
    }

    typeLine();

    // Handle form submissions
    document.getElementById('membershipForm').addEventListener('submit', function(e) {
        e.preventDefault();
        // Simulate form submission
        alert('Form submitted!');
        // Implement email sending logic here
        console.log('Form data:', new FormData(this));
    });
});