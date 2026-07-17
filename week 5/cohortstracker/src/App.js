import './App.css';
import CohortDetails from './CohortDetails';

const cohortList = [
  {
    code: 'INTADMDF10',
    program: '.NET FSD',
    startDate: '22-Feb-2022',
    status: 'Scheduled',
    coach: 'Aashma',
    trainer: 'Jojo Jose'
  },
  {
    code: 'ADM21JF014',
    program: 'Java FSD',
    startDate: '10-Sep-2021',
    status: 'Ongoing',
    coach: 'Apoorv',
    trainer: 'Elsa Smith'
  },
  {
    code: 'CDBJF21025',
    program: 'Java FSD',
    startDate: '24-Dec-2021',
    status: 'Ongoing',
    coach: 'Aashma',
    trainer: 'John Doe'
  }
];

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <CohortDetails cohorts={cohortList} />
    </div>
  );
}

export default App;
