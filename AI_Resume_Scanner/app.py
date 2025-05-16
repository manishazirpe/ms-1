import streamlit as st
from resume_parser import extract_text_from_pdf
from job_matcher import calculate_similarity

st.title("🧠 AI Resume Scanner with Job Matching")

uploaded_resume = st.file_uploader("Upload your Resume (PDF)", type=['pdf'])

job_description = st.text_area("Paste the Job Description here")

if st.button("Match Resume"):
    if uploaded_resume and job_description:
        with open("temp_resume.pdf", "wb") as f:
            f.write(uploaded_resume.read())

        resume_text = extract_text_from_pdf("temp_resume.pdf")
        score = calculate_similarity(resume_text, job_description)

        st.success(f"🔍 Matching Score: {score * 100:.2f}%")
    else:
        st.warning("Please upload a resume and enter a job description.")
