import React from 'react';
import styles from './CohortDetails.module.css';

export default function CohortDetails({ cohorts }) {
  return (
    <div style={{ textAlign: 'center' }}>
      <h1 style={{ textAlign: 'left', marginLeft: '10px' }}>Cohorts Details</h1>
      <div>
        {cohorts.map((cohort, index) => (
          <div key={index} className={styles.box}>
            <h3 style={{ color: cohort.status.toLowerCase() === 'ongoing' ? 'green' : 'blue' }}>
              {cohort.code} - {cohort.program}
            </h3>
            <dl>
              <dt>Started On</dt>
              <dd style={{ margin: '0 0 10px 0' }}>{cohort.startDate}</dd>
              <dt>Current Status</dt>
              <dd style={{ margin: '0 0 10px 0' }}>{cohort.status}</dd>
              <dt>Coach</dt>
              <dd style={{ margin: '0 0 10px 0' }}>{cohort.coach}</dd>
              <dt>Trainer</dt>
              <dd style={{ margin: '0 0 10px 0' }}>{cohort.trainer}</dd>
            </dl>
          </div>
        ))}
      </div>
    </div>
  );
}
